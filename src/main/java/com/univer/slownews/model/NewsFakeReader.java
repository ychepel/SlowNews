package com.univer.slownews.model;

import java.util.ArrayList;
import java.util.List;

public class NewsFakeReader implements NewsReader {

    public List<News> getNews() {
        List<News> news = new ArrayList<>();
        news.add(new News("The only surviving recording of Virginia Woolf",
                "A beautiful animation of the writer’s 1937 broadcast",
                "http://ichef.bbci.co.uk/wwhp/304/ibroadcast/images/live/p0/3p/1f/p03p1f6s.jpg",
                ""));
        news.add(new News("When Death Valley comes back to life",
                "A rare \"superbloom\" carpets the desert with flowers",
                "http://ichef.bbci.co.uk/wwhp/304/ibroadcast/images/live/p0/3n/pc/p03npc66.jpg",
                ""));
        news.add(new News("The downside to retiring in paradise",
                "Want to spend your golden years in the sun? Read this first",
                "http://ichef.bbci.co.uk/wwhp/304/ibroadcast/images/live/p0/3n/2h/p03n2hj4.jpg",
                ""));
        news.add(new News("The unlucky names that break computers",
                "These people face daily annoyance because of what they're called",
                "http://ichef.bbci.co.uk/wwhp/304/ibroadcast/images/live/p0/3n/xy/p03nxyjn.jpg",
                ""));
        news.add(new News("The abandoned mansions of billionaires",
                "Will this desert wasteland see new life?",
                "http://ichef.bbci.co.uk/wwhp/304/ibroadcast/images/live/p0/3m/9w/p03m9wqx.jpg",
                ""));
        news.add(new News("The return of the lynx",
                "A breeding programme that has tripled numbers of lynx in Spain may now be followed by the...",
                "http://ichef.bbci.co.uk/wwhp/304/cpsprodpb/104F4/production/_88940866_eurasianlynx_afp976promo.jpg",
                ""));
        return news;
    }
}
