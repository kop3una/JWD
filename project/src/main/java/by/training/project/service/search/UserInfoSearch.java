package by.training.project.service.search;

import by.training.project.beans.UserInfo;

import java.util.List;

public class UserInfoSearch extends EntitySearch<UserInfo> {

    public UserInfoSearch(List<UserInfo> userInfoList) {
        super(userInfoList);
    }
}
