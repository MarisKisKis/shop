package com.example.shop.service;

import com.example.shop.model.DesktopPC;
import com.example.shop.model.HardDrive;
import com.example.shop.model.Laptop;
import com.example.shop.model.Monitor;
import com.example.shop.model.dto.ItemDto;
import com.example.shop.repository.DesktopPCRepository;
import com.example.shop.repository.HardDriveRepository;
import com.example.shop.repository.LaptopRepository;
import com.example.shop.repository.MonitorRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

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
        long amount = Long.parseLong(itemDto.getAmountAtStock());
        if (itemDto.getDesktopPCDto()!= null) {
            desktopPCRepository.save(ItemMapper.toDesktopPC(itemDto));
        } else if (itemDto.getHardDriveDto() != null) {
            hardDriveRepository.save(ItemMapper.toHardDrive(itemDto));
        } else if (itemDto.getLaptopDto() != null) {
            laptopRepository.save(ItemMapper.toLaptop(itemDto));
        } else if (itemDto.getMonitorDto() != null) {
            Monitor monitor = new Monitor();
            monitor.setSerialNumber(itemDto.getSerialNumber());
            monitor.setProducer(itemDto.getProducer());
            monitor.setPrice(itemDto.getPrice());
            monitor.setAmountAtStock(amount);
            monitor.setDiagonalValue(itemDto.getMonitorDto().getDiagonalValue());
            monitor.setMeasureUnit(itemDto.getMonitorDto().getMeasureUnit());
            monitorRepository.save(monitor);
        }
    }

    @Override
    public List<ItemDto> getAllItemsByType(String itemType) {
        List<ItemDto> itemsToReturn = new ArrayList<>();
        if (itemType == "desktopPC") {
            itemsToReturn = desktopPCRepository.findAll()
                    .stream()
                    .map(ItemMapper::toItemDtoFromPc)
                    .collect(Collectors.toList());
        } else if (itemType == "hardDrive"){
            itemsToReturn = hardDriveRepository.findAll()
                    .stream()
                    .map(ItemMapper::toItemDtoFromHardDrive)
                    .collect(Collectors.toList());
        } else if (itemType == "laptop"){
            itemsToReturn = laptopRepository.findAll()
                    .stream()
                    .map(ItemMapper::toItemDtoFromLaptop)
                    .collect(Collectors.toList());
        } else if (Objects.equals(itemType, "monitor")){
            itemsToReturn = monitorRepository.findAll()
                    .stream()
                    .map(ItemMapper::toItemDtoFromMonitor)
                    .collect(Collectors.toList());
        }
        return itemsToReturn;
    }

    @Override
    public HardDrive getHardDrive(long id) {
        Optional<HardDrive> hardDriveOpt = hardDriveRepository.findById(id);
        if (hardDriveOpt.isEmpty()) {
            throw new EntityNotFoundException();
        }
        HardDrive hardDrive = hardDriveOpt.get();
        return hardDrive;
    }

    @Override
    public DesktopPC getPCById(long id) {
        Optional<DesktopPC> desktopPCOpt = desktopPCRepository.findById(id);
        if (desktopPCOpt.isEmpty()) {
            throw new EntityNotFoundException();
        }
        DesktopPC desktopPC = desktopPCOpt.get();
        return desktopPC;
    }

    @Override
    public Laptop getLaptop(long id) {
        Optional<Laptop> laptopOpt = laptopRepository.findById(id);
        if (laptopOpt.isEmpty()) {
            throw new EntityNotFoundException();
        }
        Laptop laptop = laptopOpt.get();
        return laptop;
    }

    @Override
    public Monitor getMonitor(long id) {
        Optional<Monitor> monitorOpt = monitorRepository.findById(id);
        if (monitorOpt.isEmpty()) {
            throw new EntityNotFoundException();
        }
        Monitor monitor = monitorOpt.get();
        return monitor;
    }

    @Override
    public ItemDto updateItem(long id, ItemDto itemDto, String itemType) {
        ItemDto returnItemDto = itemDto;
        switch (itemType) {
            case ("desktopPC"):
                DesktopPC desktopPC = getPCById(id);
                if (itemDto.getSerialNumber() != null) {
                    desktopPC.setSerialNumber(itemDto.getSerialNumber());
                }
                if (itemDto.getProducer() != null) {
                    desktopPC.setProducer(itemDto.getProducer());
                }
                if (itemDto.getPrice() != 0) {
                    desktopPC.setPrice(itemDto.getPrice());
                }
                if (itemDto.getAmountAtStock() != null) {
                    desktopPC.setAmountAtStock(Long.parseLong(itemDto.getAmountAtStock()));
                }
                if (itemDto.getDesktopPCDto().getFormFactor() != null) {
                    desktopPC.setFormFactor(itemDto.getDesktopPCDto().getFormFactor());
                }
                desktopPCRepository.save(desktopPC);
                returnItemDto = ItemMapper.toItemDtoFromPc(getPCById(id));
                break;
            case ("hardDrive"):
                HardDrive hardDrive = getHardDrive(id);
                if (itemDto.getSerialNumber() != null) {
                    hardDrive.setSerialNumber(itemDto.getSerialNumber());
                }
                if (itemDto.getProducer() != null) {
                    hardDrive.setProducer(itemDto.getProducer());
                }
                if (itemDto.getPrice() != 0) {
                    hardDrive.setPrice(itemDto.getPrice());
                }
                if (itemDto.getAmountAtStock() != null) {
                    hardDrive.setAmountAtStock(Long.parseLong(itemDto.getAmountAtStock()));
                }
                if (itemDto.getHardDriveDto().getVolumeValue() != 0) {
                    hardDrive.setVolumeValue(itemDto.getHardDriveDto().getVolumeValue());
                }
                if (itemDto.getHardDriveDto().getMeasureUnit() != null) {
                    hardDrive.setMeasureUnit(itemDto.getHardDriveDto().getMeasureUnit());
                }
                hardDriveRepository.save(hardDrive);
                returnItemDto = ItemMapper.toItemDtoFromHardDrive(getHardDrive(id));
                break;
            case ("laptop"):
                Laptop laptop = getLaptop(id);
                if (itemDto.getSerialNumber() != null) {
                    laptop.setSerialNumber(itemDto.getSerialNumber());
                }
                if (itemDto.getProducer() != null) {
                    laptop.setProducer(itemDto.getProducer());
                }
                if (itemDto.getPrice() != 0) {
                    laptop.setPrice(itemDto.getPrice());
                }
                if (itemDto.getAmountAtStock() != null) {
                    laptop.setAmountAtStock(Long.parseLong(itemDto.getAmountAtStock()));
                }
                if (itemDto.getLaptopDto().getSize() != 0) {
                    laptop.setSize(itemDto.getLaptopDto().getSize());
                }
                laptopRepository.save(laptop);
                returnItemDto = ItemMapper.toItemDtoFromLaptop(getLaptop(id));
                break;
            case ("monitor"):
                Monitor monitor = getMonitor(id);
                if (itemDto.getSerialNumber() != null) {
                    monitor.setSerialNumber(itemDto.getSerialNumber());
                }
                if (itemDto.getProducer() != null) {
                    monitor.setProducer(itemDto.getProducer());
                }
                if (itemDto.getPrice() != 0) {
                    monitor.setPrice(itemDto.getPrice());
                }
                if (itemDto.getAmountAtStock() != null) {
                    monitor.setAmountAtStock(Long.parseLong(itemDto.getAmountAtStock()));
                }
                if (itemDto.getMonitorDto().getDiagonalValue() != 0) {
                    monitor.setDiagonalValue(itemDto.getMonitorDto().getDiagonalValue());
                }
                if (itemDto.getMonitorDto().getMeasureUnit() != null) {
                    monitor.setMeasureUnit(itemDto.getMonitorDto().getMeasureUnit());
                }
                monitorRepository.save(monitor);
                returnItemDto = ItemMapper.toItemDtoFromMonitor(getMonitor(id));
                break;
        }
            return returnItemDto;
    }
}
