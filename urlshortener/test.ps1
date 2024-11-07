# create new short url
# http://localhost:8080/urls
curl -X POST "http://localhost:8080/api/shorten" `
     -H "Content-Type: application/json" `
     -d '{"longUrl": "https://www.google.com/search?q=goog+stock&sca_esv=308f0487964e9284&sxsrf=ADLYWILC8xfOinjUfV5tlHwl4Nf7qkf_6w%3A1730997716397&ei=1O0sZ9T8F4udseMP9YvbsAk&ved=0ahUKEwjUtvj_1MqJAxWLTmwGHfXFFpYQ4dUDCA8&uact=5&oq=goog+stock&gs_lp=Egxnd3Mtd2l6LXNlcnAiCmdvb2cgc3RvY2syDxAAGIAEGEMYigUYRhj6ATINEAAYgAQYsQMYgwEYCjIFEAAYgAQyDRAAGIAEGLEDGIMBGAoyBRAAGIAEMg0QLhiABBjRAxjHARgKMgcQABiABBgKMgcQABiABBgKMgcQABiABBgKMgcQABiABBgKMhsQABiABBhDGIoFGEYY-gEYlwUYjAUY3QTYAQJIwAtQyQNYnwpwAXgBkAEAmAFSoAGwA6oBATa4AQPIAQD4AQGYAgegAsoDwgIKEAAYsAMY1gQYR8ICDRAAGIAEGLADGEMYigXCAhkQLhiABBiwAxjRAxhDGMcBGMgDGIoF2AEBwgIZEC4YgAQYsQMY0QMYQxiDARjHARjJAxiKBcICEBAAGIAEGLEDGEMYgwEYigXCAgoQABiABBhDGIoFwgILEAAYgAQYkgMYigXCAigQLhiABBixAxjRAxhDGIMBGMcBGMkDGIoFGJcFGNwEGN4EGOAE2AECwgIKEAAYgAQYsQMYCpgDAIgGAZAGC7oGBAgBGAi6BgYIAhABGBSSBwE3oAfrOA&sclient=gws-wiz-serp"}' `
     -v

# use the short code
curl -X GET "http://localhost:8080/api/{code}}" \
     -v

# get all url pairs
curl -X GET "http://localhost:8080/api/all" \
     -v

# check for nonexistent
curl -X GET "http://localhost:8080/api/nonexistentcode" \
     -v

# note: to build maven project, use ./mvnw spring-boot:run