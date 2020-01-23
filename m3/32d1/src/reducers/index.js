import { FETCHING_ACTIVITY_START, FETCHING_ACTIVITY_SUCCESS, FETCHING_ACTIVITY_FAILURE } from '../actions';

const initialState = {
	isLoading: false,
	activity: null,
	error: '',
	hdurl: ''
};

export const reducer = (state = initialState, action) => {
	switch (action.type) {
		case FETCHING_ACTIVITY_START:
			return {
				...state,
				isLoading: true
			};
		case FETCHING_ACTIVITY_SUCCESS:
			return {
				...state,
				isLoading: false,
				activity: action.payload,
				hdurl: action.payload.hdurl
			};
		default:
			return state;
	}
};
