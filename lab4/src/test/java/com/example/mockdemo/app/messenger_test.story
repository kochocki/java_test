Given a messenger

When set server to wp.pl
Then testing connection should return 0

When set server to wp.com
Then testing connection should return 1

When set server to inf.ug.edu.pl
Then testing connection should return 0

When set server to fo
Then testing connection should return 1

When set server to wp.pl
When set message to foobar
Then sending a message should return 0

When set server to fo
When set message to foobar
Then sending a message should return 2

When set server to inf.ug.edu.pl
When set message to foo
Then sending a message should return 0

When set server to w.pl
When set message to fo
Then sending a message should return 2

When set server to inf.ug.edu
When set message to foobar
Then sending a message should return 1