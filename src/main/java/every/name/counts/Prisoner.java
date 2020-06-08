package every.name.counts;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Prisoner {
    private String prisonerNumber;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String dateOfDeath;
    private String placeOfBirth;
    private String addressLine1;
    private String addressLine2;
    private String occupation;
    private String religion;
    private String nationality;
    private String category;
    private String imprisonmentStartDate;
}
