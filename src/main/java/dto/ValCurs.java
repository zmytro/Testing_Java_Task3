package dto;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@XStreamAlias("ValCurs")
public class ValCurs {
    @XStreamAlias("Date")
    @XStreamAsAttribute
    private String date;
    @XStreamAlias("Name")
    @XStreamAsAttribute
    private String Name;

    private List<Valute> valutes = new ArrayList<>();
}
