package com.android.praktikum.pariwisata;

import java.util.ArrayList;

public class MybeachData {
    private static String[] namaPantai={
            "Pantai Tegal Wangi Jimbaran",
            "Pantai Karma Bali",
            "Pantai Melasti",
            "Pantai Tanah Lot",
            "Pantai Tulamben",
            "Pantai Kuta",
            "Pantai Pandawa"
    };
    private static String[] nameWebsite={
            "https://www.water-sport-bali.com/pantai-tegal-wangi-jimbaran/",
            "https://www.water-sport-bali.com/karma-beach-bali/",
            "https://www.water-sport-bali.com/pantai-melasti-ungasan/",
            "https://www.water-sport-bali.com/tanah-lot-bali/",
            "https://www.water-sport-bali.com/tulamben-bali/",
            "https://www.water-sport-bali.com/pantai-kuta/",
            "https://www.water-sport-bali.com/pantai-pandawa/"
    };
    private static int[] photoPantai={
            R.drawable.tegalwangi,
            R.drawable.karma,
            R.drawable.melasti,
            R.drawable.tanahlot,
            R.drawable.tulamben,
            R.drawable.kuta,
            R.drawable.pandawa,
    };

    static ArrayList<Pantai> getListData(){
        ArrayList<Pantai> list = new ArrayList<>();
        for (int position=0; position < namaPantai.length; position++){
            Pantai pantai = new Pantai();
            pantai.setNameBeach(namaPantai[position]);
            pantai.setWebsite(nameWebsite[position]);
            pantai.setPhoto(photoPantai[position]);
            list.add(pantai);
        }
        return list;
    }
}
