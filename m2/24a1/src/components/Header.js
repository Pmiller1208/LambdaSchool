import React from "react";
import styled from 'styled-components';


  	// TODO: 3 Not only are standard network request techniques employed, the code is organized in such a fashion that the student demonstrated proper use of container vs presentational components or other industry standards, conventions or patterns.
  
	// TODO: 3 Student showed great insight in setting up the state management for the app's forms. 
	// TODO: 2 proper usage of state and props are demonstrated throughout the project
  	// TODO: 2 proper usage of useState and useEffect hooks are clearly incorporated and correctly implemented. 
  
	// TODO: 3 Student incorporated a third party event/animation library like unto Greensock, Anime, React-motion etc.
  	// TODO: 2 Student used Array methods to dynamically render HTML elements.
	// TODO: 3 Loading states and success/error notifications are in place and add to the overall UX of the app.
  	// TODO: 3 Student used advanced React techniques like the composition pattern, custom hooks, render props, HOCs, etc.
  
  	// TODO: 3 Student was able to architect components to be easily reused. 
	// TODO: 2 Student created functional components and used events in application to add dynamic functionality to app.
	// TODO: 2 the UI is composed of small reusable components
	// TODO: 2 Student's code was organized at the component level
	// TODO: 2 Student has set up component management for the forms in the app that makes sense for each form. 

	// TODO:  Combine all headers into one if you have time

	
const AppHeader = styled.header`
  border-bottom: 2px solid #383651;
  font-weight: bold;
  margin: 0 1em;
  padding: 1em 1em;
  display: flex;
  flex-wrap: nowrap;
  width: 100%;
`

const AppName = styled.h1`
  color: #383651;
  font-weight: bold;
  align-text: right;
`

export default function Header() {
  return (
	  <AppHeader className="">
		  <img src={`${process.env.PUBLIC_URL}/img/lambda-logo.png`}/>
		  <AppName className="">DevDesk</AppName>
    </AppHeader>
  );
}
