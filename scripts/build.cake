var target = Argument("target", "Default");

Task("Default")
  .Does(() =>
{
  MSBuild("../client/GameOfELTE.sln");
});

