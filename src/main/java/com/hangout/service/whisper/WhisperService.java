package com.hangout.service.whisper;

import com.hangout.entity.Whisper;

import java.util.ArrayList;

public interface WhisperService {
    public void send(String from_id,String to_id,String content);
    public ArrayList<Whisper> receive(String to_id);
}
