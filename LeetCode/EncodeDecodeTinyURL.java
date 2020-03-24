public class Codec {

    public static HashMap<String, String> hashMap = new HashMap<>();

	// Encodes a URL to a shortened URL.
	public String encode(String longUrl) {
		String prefix = "http://tinyurl.com/";
		String url = prefix + longUrl.hashCode();
		hashMap.put(url,longUrl);
		return url;
	}

	// Decodes a shortened URL to its original URL.
	public String decode(String shortUrl) {
		return hashMap.get(shortUrl);
	}
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));