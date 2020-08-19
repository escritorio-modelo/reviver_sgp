package net.projetoreviver.sgp.configs;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorConfig implements ErrorController{

	@RequestMapping("/error")
	public String handleError(HttpServletRequest request) {
		Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
		if(status != null) {
			Integer code = Integer.valueOf(status.toString());
			if(code == HttpStatus.NOT_FOUND.value()) {
				return "erros/404";
			}
			else if(code == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
				return "erros/500";
			}
			if(code == HttpStatus.FORBIDDEN.value()) {
				return "erros/403";
			}
		}
		return "erros/geral";
	}
	
	@Override
	public String getErrorPath() {
		return "/error";
	}

}
