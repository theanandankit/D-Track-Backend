package com.atlan.DatabaseExportService.Models.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GoogleSheetDTOResponse {

    private String googleSheetLnk;

    private String created;

}
