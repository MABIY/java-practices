package org.example.endpoints.object_to_xml;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lh
 */
@RestController
@RequestMapping("/test")
public class TestController {
    @GetMapping("/")
    public void test() throws Exception {
        IdentificationToXML.test();
    }
}
