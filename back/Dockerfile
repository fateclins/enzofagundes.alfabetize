# uma docker image para rodar um projeto com bun e express
FROM oven/bun:1.1.8
WORKDIR /usr/src/app
COPY package.json bun.lockb /temp/dev/
RUN cd /temp/dev && bun install --frozen-lockfile
COPY . .
CMD ["bun", "run", "start"]
