package co.edu.uco.ucobet.controller.response;

import java.util.List;

import co.edu.uco.crosscutting.helpers.ObjectHelper;

public abstract class ResponseWithData<T> extends Response {
		
		private List<T> data;

		public List<T> getData() {
			return data;
		}

		public void setData(List<T> data) {
			this.data = ObjectHelper.getDefault(data, this.data);
		}
		
		
	}
	

