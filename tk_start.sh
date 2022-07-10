docker build -t okygogo_test .


docker run \
    -d \
    -p 2022:8080 \
    --name okygogo_test_instance \
    okygogo_test

#docker restart okygogo_test_instance
