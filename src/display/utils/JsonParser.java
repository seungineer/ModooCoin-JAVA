package display.utils;

public class JsonParser {
    /*
        json : 순수 문자열
        key : 원하는 타깃감
     */
    public String extractJsonValue(String json, String key) {
        String target = "\"" + key + "\":";
        int startIdx = json.indexOf(target);
        if (startIdx == -1) return null;

        int valueStart = startIdx + target.length();

        // 값이 문자열인지 숫자인지 판단
        if (json.charAt(valueStart) == '"') {
            int endIdx = json.indexOf('"', valueStart + 1);
            return json.substring(valueStart + 1, endIdx);
        } else {
            int endIdx = json.indexOf(',', valueStart);
            if (endIdx == -1) endIdx = json.indexOf('}', valueStart); // 마지막 값 처리
            return json.substring(valueStart, endIdx).trim();
        }
    }
}
