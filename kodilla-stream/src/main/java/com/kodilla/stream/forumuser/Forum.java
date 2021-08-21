package com.kodilla.stream.forumuser;

import java.util.ArrayList;
import java.util.List;

public class Forum {
    private final List<ForumUser> forumUserList = new ArrayList<>();
    public Forum(){
        forumUserList.add(new ForumUser(1,"Dylan Murphy", 'M',
                1990, 10, 15, 15));
        forumUserList.add(new ForumUser(2,"Phoebe Pearson", 'F',
                2010, 9, 13, 17));
        forumUserList.add(new ForumUser(3, "Morgan Walsh",'M',
                2005, 8, 11, 13));
        forumUserList.add(new ForumUser(4, "Aimee Murphy", 'F',
                1977, 7, 9, 19));
        forumUserList.add(new ForumUser(5, "Ryan Talley",'M',
                1998, 6, 7, 11));
        forumUserList.add(new ForumUser(6, "Madelynn Carson",'F',
                2003, 5, 5, 21));
        forumUserList.add(new ForumUser(7, "Giancarlo Guerrero",'M',
                1985, 4, 3, 9));
    }

    public List<ForumUser> getForumUserList() {
        return forumUserList;
    }

}
