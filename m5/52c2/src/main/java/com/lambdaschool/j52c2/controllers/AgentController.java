package com.lambdaschool.j52c2.controllers;

public class AgentController {

    @Autowired
    private AgentService agentService;

    // GET all agents
    // http://localhost:2019/agents/agents
    @GetMapping(value = "/agents/agents",
            produces = {"application/json"})
    public ResponseEntity<?> listAllAgents(){

        List<Agent> myAgents = agentService.findAll();
        return new ResponseEntity<>(myAgents, HttpStatus.OK);
    }

    // GET one agent by id
    // http://localhost:2019/agents/agent/{agentid}
    @GetMapping(value = "/agent/{agentId}",
            produces = {"application/json"})
    public ResponseEntity<?> getAgentById(@PathVariable Long agentId) {
        Agent r = agentService.findAgentById(agentId);
        return new ResponseEntity<>(r, HttpStatus.OK);
    }

    // GET one agent by name
    // http://localhost:2019/agents/agent/{agentName}
    @GetMapping(value = "/agent/name/{agentName}",
            produces = {"application/json"})
    public ResponseEntity<?> getAgentByName(@PathVariable String agentName) {
        Agent r = agentService.findAgentByName(agentName);
        return new ResponseEntity<>(r, HttpStatus.OK);
    }

    // GET one agent by telephone
    // http://localhost:2019/agents/agent/{agentPhone}
    @GetMapping(value = "/agent/phone/{agentPhone}",
            produces = {"application/json"})
    public ResponseEntity<?> getAgentByTelephone(@PathVariable String agentPhone) {
        Agent r = agentService.findAgentByTelephone(agentPhone);
        return new ResponseEntity<>(r, HttpStatus.OK);
    }
    // DELETE one agent
    // http://localhost:2019/agents/agent/{agentid}
    @DeleteMapping(value = "/agent/{agentId}")
    public ResponseEntity<?> deleteAgentById(@PathVariable Long agentId) {
        agentService.delete(agentId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // PUT one agent
    // http://localhost:2019/agents/agent/{agentid}
    @PutMapping(value = "/agent/{agentId}",
            produces = {"application/json"},
            consumes = {"application/json"})
    public ResponseEntity<?> updateAgent(@RequestBody Agent updateAgent,
                                              @PathVariable Long agentId) {
        agentService.update(updateAgent, agentId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // POST one agent
    @PostMapping(value = "/agent",
            produces = {"application/json"},
            consumes = {"application/json"})
    public ResponseEntity<?> addNewAgent(@Valid
                                              @RequestBody Agent newAgent) throws URISyntaxException{
        newAgent = agentService.save(newAgent);

        // set location header for newly created resource
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newAgentURI = ServletUriComponentsBuilder.fromCurrentRequest().path("/{agentid}")
                .buildAndExpand(newAgent.getAgentid()).toUri();
        responseHeaders.setLocation(newAgentURI);

        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }
}
