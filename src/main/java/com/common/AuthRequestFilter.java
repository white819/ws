package com.common;

import java.io.IOException;
import java.security.Principal;

import javax.annotation.Priority;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.ext.Provider;

import sun.security.acl.PrincipalImpl;

@Provider
@Priority(Priorities.AUTHENTICATION)
public class AuthRequestFilter implements ContainerRequestFilter {
    @Context
    HttpServletRequest webRequest;

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        final HttpSession session = webRequest.getSession();
        requestContext.setSecurityContext(new SecurityContext() {
            @Override
            public Principal getUserPrincipal() {
                return new PrincipalImpl((String)session.getAttribute("USER_NAME"));
            }

            @Override
            public boolean isUserInRole(String s) {
                return false;
            }

            @Override
            public boolean isSecure() {
                return false;
            }

            @Override
            public String getAuthenticationScheme() {
                return null;
            }
        });
    }
}
