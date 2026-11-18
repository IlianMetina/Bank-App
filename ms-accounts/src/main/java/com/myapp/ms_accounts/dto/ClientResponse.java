package com.myapp.ms_accounts.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientResponse <T>{

    private T data;
    private boolean serviceAvailable;
    private String message;
}
