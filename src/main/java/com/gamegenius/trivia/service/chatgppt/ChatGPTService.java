package com.gamegenius.trivia.service.chatgppt;

import io.github.flashvayne.chatgpt.dto.ChatRequest;
import io.github.flashvayne.chatgpt.dto.ChatResponse;
import io.github.flashvayne.chatgpt.service.ChatgptService;
import org.springframework.stereotype.Service;

@Service
public class ChatGPTService {
    private final ChatgptService chatgptService;

    public ChatGPTService(ChatgptService chatgptService) {
        this.chatgptService = chatgptService;
    }

    public ChatResponse prompt(String message){
        Integer maxTokens = 300;
        String model = "gpt-3.5-turbo";
        Double temperature = 0.5;
        Double topP = 1.0;
        ChatRequest chatRequest = new ChatRequest(model,message,maxTokens,temperature,topP);
        ChatResponse res = chatgptService.sendChatRequest(chatRequest);
        System.out.println("Response was: "+res.toString());
        return res;
    }

    public String getMessage(String message){
        try {
            return chatgptService.sendMessage(message);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
