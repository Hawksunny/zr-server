package com.zr.service.car;

import com.zr.vo.car.Work;

import java.util.List;

public interface WorkService {
    List<Work> list(Work work);

    void update(Work work);
}
