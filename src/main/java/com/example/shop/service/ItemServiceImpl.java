package com.example.shop.service;

import com.example.shop.model.ItemDto;
import com.example.shop.repository.DesktopPCRepository;
import com.example.shop.repository.HardDriveRepository;
import com.example.shop.repository.LaptopRepository;
import com.example.shop.repository.MonitorRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ItemServiceImpl implements ItemService{

    private final DesktopPCRepository desktopPCRepository;

    private final LaptopRepository laptopRepository;

    private final MonitorRepository monitorRepository;

    private final HardDriveRepository hardDriveRepository;

    @Autowired
    public ItemServiceImpl(DesktopPCRepository desktopPCRepository, LaptopRepository laptopRepository,
                           MonitorRepository monitorRepository, HardDriveRepository hardDriveRepository) {
        this.desktopPCRepository = desktopPCRepository;
        this.laptopRepository = laptopRepository;
        this.monitorRepository = monitorRepository;
        this.hardDriveRepository = hardDriveRepository;
    }

    @Override
    public void save(ItemDto itemDto) {
        if (itemDto.getDesktopPCDto()!= null) {
            desktopPCRepository.save(ItemMapper.ToDesktopPC(itemDto));
        }
    }
}
