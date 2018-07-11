package com.sk.base.controller;

import com.sk.base.commons.Result;
import com.sk.base.commons.ResultState;

public abstract class BaseController {
    public static final Result SUCCESS = new Result(ResultState.SUCCESS, "操作成功");
    public static final Result FAIL = new Result(ResultState.FAIL, "操作失败");
}
