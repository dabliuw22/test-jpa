
package com.leyton.examplejpa.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.leyton.examplejpa.dto.GroupingDto;
import com.leyton.examplejpa.service.inter.GroupingService;

@RestController
@RequestMapping(
        value = "/groupings")
public class GroupingController {

    private static final Logger LOGGER = LoggerFactory.getLogger(GroupingController.class);

    @Autowired
    private GroupingService groupingService;

    @GetMapping
    public ResponseEntity<Set<GroupingDto>> getGrouping(@RequestParam(
            value = "email",
            required = true) String email) {
        return ResponseEntity.ok(groupingService.findByPartnerEmail(email));
    }

    @GetMapping(
            value = {
                "/{id}"
            })
    public ResponseEntity<GroupingDto> getGrouping(@PathVariable(
            value = "id") Long id) {
        return ResponseEntity.ok(groupingService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> save(@RequestBody GroupingDto grouping) {
        Map<String, Object> response = new HashMap<>();
        boolean created = groupingService.save(grouping);
        response.put("created", created);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestBody GroupingDto grouping) {
        boolean updated = groupingService.save(grouping);
        LOGGER.info("Status update grouping [{}]: {}", grouping, updated);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(
            value = {
                "/{id}"
            })
    public ResponseEntity<Void> deleteGrouping(@PathVariable(
            value = "id") Long id) {
        boolean deleted = groupingService.delete(id);
        LOGGER.info("Status delete grouping-id[{}]: {}", id, deleted);
        return ResponseEntity.noContent().build();
    }
}
