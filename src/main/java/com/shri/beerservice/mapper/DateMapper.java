/*
 * Created by  ZeeroIQ on 9/10/20, 11:45 PM
 */

package com.shri.beerservice.mapper;

import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

@Component
public class DateMapper {
    public OffsetDateTime asOffsetDateTime(Timestamp time) {
        if (time != null) {
            return OffsetDateTime.of(
                    time.toLocalDateTime().getYear(),
                    time.toLocalDateTime().getMonthValue(),
                    time.toLocalDateTime().getDayOfMonth(),
                    time.toLocalDateTime().getHour(),
                    time.toLocalDateTime().getMinute(),
                    time.toLocalDateTime().getSecond(),
                    time.toLocalDateTime().getNano(), ZoneOffset.UTC);
        } else {
            return null;
        }
    }

    Timestamp asTimeStamp(OffsetDateTime time) {
        return time != null
                ? Timestamp.valueOf(time.atZoneSameInstant(ZoneOffset.UTC).toLocalDateTime())
                : null;
    }
}
