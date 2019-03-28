package org.openjfx.logic.AppInfo;


//Enkel klasse for versjon info, github link, etc i "About"

public class AppInfo {

    private final static String versjon = "DAILY_13-TORSDAG";
    private final static String git = "https://github.com/MagnusHJK/SemesterOppgaveProgutvikling";
    private final static String gruppe = "gruppe 40";

    public String getVersjon(){
        return versjon;
    }

    public String getGit(){
        return git;
    }

    public String getGruppe(){
        return gruppe;
    }

    @Override
    public String toString(){

        return "Versjon: " + getVersjon() + "\n" +
               "Laget av " + getGruppe() +
               "GitHub: " + getGit();
    }
}
