package venkat.springboot.simple.chatgpt.config.properties;

public class ImageProperties {

	private String apiKey;

    private String url = "https://api.openai.com/v1/completions";

    private String model;

    private Integer maxTokens;

    private Double temperature;

    private Double topP;

    private MultiChatProperties multi;

    private ImageProperties image;

}
