package com.nhnchina.demoexcelopt.model;

import java.util.List;

public class AllTypeRaxVO {
    private String title1;
    private String title2;
    private String title3;
    private String title4;
    private String title5;
    private String title6;
    private List<ParentVO> parentVOList;
    private List<ChildrenVO> childrenVOList;
    private PrototypeCreditVO prototypeCreditVO;

    public String getTitle1() {
        return title1;
    }

    public void setTitle1(String title1) {
        this.title1 = title1;
    }

    public String getTitle2() {
        return title2;
    }

    public void setTitle2(String title2) {
        this.title2 = title2;
    }

    public String getTitle3() {
        return title3;
    }

    public void setTitle3(String title3) {
        this.title3 = title3;
    }

    public String getTitle4() {
        return title4;
    }

    public void setTitle4(String title4) {
        this.title4 = title4;
    }

    public String getTitle5() {
        return title5;
    }

    public void setTitle5(String title5) {
        this.title5 = title5;
    }

    public String getTitle6() {
        return title6;
    }

    public void setTitle6(String title6) {
        this.title6 = title6;
    }

    public List<ParentVO> getParentVOList() {
        return parentVOList;
    }

    public void setParentVOList(List<ParentVO> parentVOList) {
        this.parentVOList = parentVOList;
    }

    public List<ChildrenVO> getChildrenVOList() {
        return childrenVOList;
    }

    public void setChildrenVOList(List<ChildrenVO> childrenVOList) {
        this.childrenVOList = childrenVOList;
    }

    public PrototypeCreditVO getPrototypeCreditVO() {
        return prototypeCreditVO;
    }

    public void setPrototypeCreditVO(PrototypeCreditVO prototypeCreditVO) {
        this.prototypeCreditVO = prototypeCreditVO;
    }
}
