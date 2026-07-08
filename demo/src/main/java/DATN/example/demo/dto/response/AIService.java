package DATN.example.demo.dto.response;

import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class AIService {

    private Process process;

    public void startAI(){
        System.out.println("===== START AI =====");
        if(process != null && process.isAlive()){
            return;
        }
        try{
            ProcessBuilder pb = new ProcessBuilder(
                    "python",
                    "C:\\Users\\Admin\\Documents\\OpenCV\\posture_monitor.py"
            );
            pb.inheritIO();
            process = pb.start();
        } catch (IOException e) {
            throw new RuntimeException("Không thể khởi động AI", e);
        }
    }

    public void stopAI(){
        if(process != null && process.isAlive()){
            process.destroyForcibly();
            process = null;
        }
    }
}
