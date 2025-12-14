package oncall.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class WorkerNames {

    private final List<String> names;

    public WorkerNames(String names) {
        List<String> nameList = toList(names);
        validate(nameList);
        this.names = nameList;
    }

    public String get(int index) {
        return names.get(index);
    }

    public int size() {
        return names.size();
    }

    public boolean hasSameWorkers(WorkerNames other) {
        return new HashSet<>(this.names).equals(new HashSet<>(other.names));
    }

    private List<String> toList(String names) {
        try {
            String[] splitNames = names.split(",");
            if (splitNames.length == 1) {
                throw new IllegalArgumentException("[ERROR] 유효하지 않은 입력 값입니다. 다시 입력해 주세요.");
                //throw new IllegalArgumentException("[ERROR] 사원 닉네임은 콤마로 구분되는 문자열입니다.");
            }
            return Arrays.stream(splitNames).toList();
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 입력 값입니다. 다시 입력해 주세요.");
            //throw new IllegalArgumentException("[ERROR] 사원 닉네임 입력이 잘못되었습니다.");
        }
    }

    private void validate(List<String> nameList) {
        int size = nameList.size();
        if (size != new HashSet<>(nameList).size()) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 입력 값입니다. 다시 입력해 주세요.");
            //throw new IllegalArgumentException("[ERROR] 비상 근무자는 평일 순번, 휴일 순번에 각각 1회 편성되어야 합니다.");
        }
    }

}
