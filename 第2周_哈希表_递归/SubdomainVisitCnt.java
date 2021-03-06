import java.util.*;

public class SubdomainVisitCnt {
    public List<String> subdomainVisits(String[] cpdomains) {
        // sanity check
        List<String> res = new ArrayList<>();
        if (cpdomains == null || cpdomains.length == 0) return res;
        Map<String, Integer> map = new HashMap<>();
        for (String domain :cpdomains) {
            String[] freqDomain = domain.split("\\s+");
            String[] domains = freqDomain[1].split("\\.");

            int freq = Integer.valueOf(freqDomain[0]);
            String cur = "";

            for (int i = domains.length - 1; i>= 0; i--) {
                if (i != domains.length - 1) cur = "." + cur;
                cur = domains[i] + cur;
                map.put(cur,  map.getOrDefault(cur, 0) + Integer.valueOf(freqDomain[0]));
            }
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            res.add(entry.getValue() + " " + entry.getKey());
        }
        return res;
    }
}
