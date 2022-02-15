package org.example.user.framework.adapters.input.stdin;

import org.example.user.core.ports.incoming.UserInputPort;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class UserCLIAdapter {
    private UserInputPort userInputPort;

    public void processRequest(Object requestParams) {
        Map<String, String> params = stdinParams(requestParams);
        UserInputPort.UserDetails userDetails = new UserInputPort.UserDetails(params.get("email"), params.get("firstName"), params.get("lastName"));
        userInputPort.addNewUser(userDetails);
    }

    private Map<String, String> stdinParams(Object requestParams) {
        Map<String, String> params = new HashMap();
        if (requestParams instanceof Scanner) {
            Scanner scanner = (Scanner) requestParams;
            System.out.println("Please put the email:");
            String email = scanner.nextLine();
            params.put("email", email);
            System.out.println("Please put the firstName:");
            String firstName = scanner.nextLine();
            params.put("firstName", firstName);
            System.out.println("Please put the lastName:");
            String lastName = scanner.nextLine();
            params.put("lastName", lastName);
        } else {
            throw new IllegalArgumentException("Request with invalid parameters");
        }
        return params;
    }
}
