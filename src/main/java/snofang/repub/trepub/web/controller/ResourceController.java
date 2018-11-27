package snofang.repub.trepub.web.controller;

import java.util.UUID;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import snofang.repub.trepub.web.view.PrincipalView;


@RestController
public class ResourceController {

	@GetMapping("/context")
	@PreAuthorize("hasAuthority('role_admin')")
	public String context() {
		PrincipalView principal = (PrincipalView) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		return principal.getUsername() + " " + principal.getEmail();
	}

	@GetMapping("/secured")
	@PreAuthorize("hasAuthority('role_admin')")
	public String secured(PrincipalView principal) {
		return principal.getUsername() + " " + principal.getEmail();
	}

	@GetMapping("/resource")
	public String resource() {
		return UUID.randomUUID().toString();
	}
}
