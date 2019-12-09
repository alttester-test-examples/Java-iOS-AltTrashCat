echo "==> Open application"
open App/TrashCatMac/TrashCat.app/
echo "==>Wait for application to start"
sleep 3

cd TestAlttrashCSharp
echo "==>Restore test project"
dotnet restore
echo "==>Run tests"
dotnet test

echo "==>Kill app"
killall TrashCat
