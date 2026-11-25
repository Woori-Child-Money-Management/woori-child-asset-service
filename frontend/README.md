# Frontend

React 기반 자녀 자산관리 서비스 프론트엔드

## 개발 환경

- Node.js 24.20.0 (24 LTS) / npm 11.19.0
- React / React DOM 19.3.1
- Vite 8.3.8
- TypeScript 7.0.2 (`strict: true`)

## 실행

이 frontend 폴더에서 실행합니다. nvm 사용자는 먼저 `nvm install` 및 `nvm use`로 Node 버전을 맞춥니다.

```bash
npm ci
npm run dev
```

개발 서버 주소: http://localhost:5173 (해당 포트 사용 중이면 실행 화면의 주소 확인)

## 확인 및 빌드

```bash
npm run typecheck
npm run lint
npm run build
npm run preview
```

`npm run build`는 타입 검사 후 배포 파일을 `dist/`에 생성합니다.
`package-lock.json`을 공유하고 팀원은 `npm ci`로 동일한 의존성을 설치합니다.
`node_modules/`, `dist/`, 로컬 `.env` 파일은 Git 추적 대상에서 제외됩니다.
