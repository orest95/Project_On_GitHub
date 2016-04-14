/**
 * Created by Orest on 15.04.2016.
 */
public class FacadeApp {

    public static void main(String[] args) {

        ReklamaFacade reklamaFacade = new ReklamaFacade();
        reklamaFacade.viewReklama();
    }
}

class ReklamaFacade {

    SubaruFacade subaruFacade = new SubaruFacade();
    LogoKanalu logoKanalu = new LogoKanalu();
    VoiceReklama voiceReklama = new VoiceReklama();

    void viewReklama() {
        subaruFacade.rolikSubaru();
        logoKanalu.logotip();
        voiceReklama.Voice();
    }


}


class SubaruFacade {
    void rolikSubaru() {
        System.out.println("рекламний ролік");
    }
}

class LogoKanalu {
    void logotip() {
        System.out.println(" правий кут - Телеканал 1+1");
    }
}

class VoiceReklama {
    void Voice() {
        System.out.println("озвучка - Купляйте Субару, наша адреса...");
    }
}