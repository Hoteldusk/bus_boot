package com.example.demo.service;

import com.example.demo.api.LoadAPIData;
import com.example.demo.mapper.TerDriveMapper;
import com.example.demo.mapper.TerLinkMapper;
import com.example.demo.mapper.TerMapper;
import com.example.demo.mapper.TerScheduleMapper;
import com.example.demo.models.TerDriveDto;
import com.example.demo.models.TerDto;
import com.example.demo.models.TerLinkDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class LoadDB {
    private LoadAPIData apiData;
    private TerMapper terMapper;
    private TerLinkMapper terLinkMapper;
    private TerDriveMapper terDriveMapper;
    private TerScheduleMapper terScheduleMapper;
    @Autowired
    public LoadDB(LoadAPIData apiData, TerMapper terMapper, TerLinkMapper terLinkMapper, TerDriveMapper terDriveMapper, TerScheduleMapper terScheduleMapper) {
        this.apiData = apiData;
        this.terMapper = terMapper;
        this.terLinkMapper = terLinkMapper;
        this.terDriveMapper = terDriveMapper;
        this.terScheduleMapper = terScheduleMapper;
    }

    // 출발 드롭다운 데이터 전송
    public List<TerDto> loadDepTerData() {
        return terMapper.getTerByRegion("광주");
    }

    // 출발지 선택시 도착지 리스트 데이터 전송
    public List<TerDto> loadArrTerData(TerDto depTerDto) {
        List<TerDto> terDtoList = new ArrayList<>();
        List<TerLinkDto> terLinkDtoList = terLinkMapper.getByDepTerID(depTerDto.getTerId());
        for (TerLinkDto terLinkDto : terLinkDtoList) {
            TerDto terDto = terMapper.getTerById(terLinkDto.getTl_ArrTerId());
            terDtoList.add(terDto);
        }
        return terDtoList;
    }

    // 출발지 도착지 드롭다운에서 선택후 시간표 게시판에 데이터 전달
    public List<TerDriveDto> loadTerDriveData(TerDto depTerDto, TerDto arrTerDto) {

        return null;
    }
}
