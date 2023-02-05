package VO;

import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class ApiResponse {

    private Object date;

    @NonNull
    private String message;
}
