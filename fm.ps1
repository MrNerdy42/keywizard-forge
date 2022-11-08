$ErrorActionPreference = 'Stop'
$env:GIT_REDIRECT_STDERR = '2>&1'

git checkout fabricMerge-1.18
If ($LASTEXITCODE -ne 0) {Exit}
git fetch fabric-origin 1.18
If ($LASTEXITCODE -ne 0) {Exit}
git checkout FETCH_HEAD src
If ($LASTEXITCODE -ne 0) {Exit}

If (Test-Path '.\src\main\java\mrnerdy42\keywizard\KeyWizard.java') {
    Remove-Item -Path '.\src\main\java\mrnerdy42\keywizard\KeyWizard.java' -Force
}

$srcFiles = Get-ChildItem -Path .\src\main\java\mrnerdy42\ -Recurse -Filter '*.java'

ForEach ($f in $srcFiles) {
    $content = $f | Get-Content -Raw
    $content = $content -replace 'mrnerdy42.keywizard.KeyWizard', 'mrnerdy42.keywizard.forge.KeyWizard'
    $content | Set-Content -Path $f.PSPath
}

git add .
If ($LASTEXITCODE -ne 0) {Exit}

Write-Host 'Basic merge complete. Remeber to manually check for errors before committing.'