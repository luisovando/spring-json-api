package com.luisovando.springboot.app.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.katharsis.resource.registry.RegistryEntry;
import io.katharsis.resource.registry.ResourceRegistry;
import io.katharsis.spring.boot.v3.KatharsisConfigV3;

@RestController
@Import({ KatharsisConfigV3.class })
public class ResourceController {

	@Autowired
	private ResourceRegistry resourceRegistry;

	@GetMapping("/resources-info")
	public Map<String, String> index() {
		Map<String, String> result = new HashMap<>();

		for (RegistryEntry entry : resourceRegistry.getResources()) {
			result.put(entry.getResourceInformation().getResourceType(),
					resourceRegistry.getResourceUrl(entry.getResourceInformation()));
		}

		return result;
	}
}
