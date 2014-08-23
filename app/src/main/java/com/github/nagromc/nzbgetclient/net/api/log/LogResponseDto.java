package com.github.nagromc.nzbgetclient.net.api.log;

import com.github.nagromc.nzbgetclient.net.dto.ResponseDto;

public class LogResponseDto extends ResponseDto<LogResponseDto.LogResultDto[]> {

	public static class LogResultDto {

		private Integer ID;
		private String Kind;
		private Integer Time;
		private String Text;

		public Integer getID() {
			return ID;
		}

		public void setID(Integer iD) {
			ID = iD;
		}

		public String getKind() {
			return Kind;
		}

		public void setKind(String kind) {
			Kind = kind;
		}

		public Integer getTime() {
			return Time;
		}

		public void setTime(Integer time) {
			Time = time;
		}

		public String getText() {
			return Text;
		}

		public void setText(String text) {
			Text = text;
		}

	}

}
