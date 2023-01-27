
  Pod::Spec.new do |s|
    s.name = 'CapacitorMusicControlsPlugin'
    s.version = '1.0.0'
    s.summary = 'Implementation of MusicControls for Capacitor projects'
    s.license = 'MIT'
    s.homepage = 'https://github.com/ingageco/capacitor-music-controls-plugin-v3'
    s.author = 'Ingage'
    s.source = { :git => 'https://github.com/ingageco/capacitor-music-controls-plugin-v3', :tag => s.version.to_s }
    s.source_files = 'ios/Plugin/**/*.{swift,h,m,c,cc,mm,cpp}'
    s.ios.deployment_target  = '12.0'
    s.dependency 'Capacitor'
    s.swift_version = '5.1'
  end