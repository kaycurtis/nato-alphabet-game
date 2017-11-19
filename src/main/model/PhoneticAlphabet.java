package main.model;
import java.util.Random;
/**
 * Created by kayla on 2017-08-10.
 */
public enum PhoneticAlphabet {
    A("ALFA"), B("BRAVO"), C("CHARLIE"), D("DELTA"), E("ECHO"), F("FOXTROT"), G("GOLF"),
    H("HOTEL"), I("INDIA"), J("JULIETT"), K("KILO"), L("LIMA"), M("MIKE"), N("NOVEMBER"), O("OSCAR"),
    P("PAPA"), Q("QUEBEC"), R("ROMEO"), S("SIERRA"), T("TANGO"), U("UNIFORM"), V("VICTOR"),
    W("WHISKEY"), X("XRAY"), Y("YANKEE"), Z("ZULU");

    private final String phonetic;

    PhoneticAlphabet(String s) {
        this.phonetic = s;
    }

    @Override
    public String toString() {
        return name();
    }


    public String getPhonetic() {
        return phonetic;
    }

}
