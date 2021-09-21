package br.com.amadeus.marketplace.dto.reader;

import com.opencsv.bean.CsvBindByName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MarketplaceReaderCsv {

    @CsvBindByName(column = "ID")
    Long id;
    @CsvBindByName(column = "LONG")
    Double longitude;
    @CsvBindByName(column = "LAT")
    Double latitude;
    @CsvBindByName(column = "SETCENS")
    String sector;
    @CsvBindByName(column = "AREAP")
    String area;
    @CsvBindByName(column = "CODDIST")
    String districtCode;
    @CsvBindByName(column = "DISTRITO")
    String districtName;
    @CsvBindByName(column = "CODSUBPREF")
    Long subCityHallCode;
    @CsvBindByName(column = "SUBPREFE")
    String subCityHallName;
    @CsvBindByName(column = "REGIAO5")
    String region05;
    @CsvBindByName(column = "REGIAO8")
    String region08;
    @CsvBindByName(column = "NOME_FEIRA")
    String name;
    @CsvBindByName(column = "REGISTRO")
    String register;
    @CsvBindByName(column = "LOGRADOURO")
    String street;
    @CsvBindByName(column = "NUMERO")
    String number;
    @CsvBindByName(column = "BAIRRO")
    String neighborhood;
    @CsvBindByName(column = "REFERENCIA")
    String reference;
    Boolean active = true;
}
