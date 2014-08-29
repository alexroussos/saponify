<html>
<head>
  <title>${title}</title>
</head>
<body>
  <h1>Test data</h1>
  Point: [${point.x},${point.y}]

  <#import "utils.ftl" as u>
  <@u.macrotest x=11 y=22 />
</body>
</html>