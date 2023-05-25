package ru.skypro.homework.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import ru.skypro.homework.dto.AdsDto;
import ru.skypro.homework.dto.CreateAdsDto;
import ru.skypro.homework.dto.FullAdsDto;
import ru.skypro.homework.entity.Ads;
import ru.skypro.homework.entity.Image;

@Mapper(uses = UserMapper.class)
public interface AdsMapper {

    AdsMapper INSTANCE = Mappers.getMapper(AdsMapper.class);

    @Mapping(source = "pk", target = "id")
    @Mapping(source = "author", target = "author.id")
    @Mapping(source = "image", target = "image.filePath")
    Ads adsDtoToAds(AdsDto adsDto);

    @Mapping(source = "id", target = "pk")
    @Mapping(source = "author.id", target = "author")
    AdsDto adsToAdsDto(Ads ad);

    Ads createAdsDtoToAds(CreateAdsDto createAdsDto);

    @Mapping(source = "author.firstName", target = "authorFirstName")
    @Mapping(source = "author.lastName", target = "authorLastName")
    @Mapping(source = "author.email", target = "email")
    @Mapping(source = "author.phone", target = "phone")
    FullAdsDto adToFullAdsDto(Ads ad);

    default String getImageApi(Image image) {
        return image.getImageApi();
    }
}
