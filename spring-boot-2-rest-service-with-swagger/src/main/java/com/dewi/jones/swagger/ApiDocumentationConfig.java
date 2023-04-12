package com.dewi.jones.swagger;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;
/**
 * Reference : <a href="https://support.intershop.com/kb/index.php/Display/2914L4">...</a>
 */
@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(
                        name = "Dewi Jones",
                        email = "dewijones92@gmail.com",
                        url = "http://www.in28minutes.com"
                )
        ))
public interface ApiDocumentationConfig {

}