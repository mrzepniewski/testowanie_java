Given a messenger
When set server name to czescwszystkim.pl
Then testConnection should return 0

When set server name to czescwszystkim.com
Then testConnection should return 1

When set server name to 1
When set message text to odpowiednialiczbaliter
Then sendMessage return 2

When set server name to czescwszystkim.com
When set message text to odpowiednialiczbaliter
Then sendMessage return 1

When set server name to czescwszystkim.pl
When set message text to odpowiednialiczbaliter
Then sendMessage return 0

When set server name to czescwszystkim.pl
When set message text to 1
Then sendMessage return 2

When set server name to czescwszystkim.pl
When set message text to odpowiednialiczbaliter
Then testConnection should return 0
Then sendMessage return 0

When set server name to czescwszystkim.com
When set message text to odpowiednialiczbaliter
Then testConnection should return 1
Then sendMessage return 1
