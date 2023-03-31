# Imersão Java

Stickers generate project, an API for create custom images from images URL.

DESIGN API:

[*POST*] http://localhost:8080/generate-stickers


```json
{
	"outputPath": "/Users/lfmelo/Desktop/Java/imersao-java/src/main/resources/assets",
	"imageURL": "https://apod.nasa.gov/apod/image/2303/WR124_Webb1024.png",
	"text": "Minha mente maluuuka",
	"fileName": "imagem2",
    "position": "MIDDLE"
}

```

- outputPath: Directory where the created images will be stored
- imageURL: URL image to create sticker
- text: Text to be will add on image
- fileName: Output file name
- position: Position where the text will be on the image
    - values: MIDDLE or BOTTOM (default BOTTOM)