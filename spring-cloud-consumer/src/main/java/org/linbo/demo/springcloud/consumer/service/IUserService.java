package org.linbo.demo.springcloud.consumer.service;

import org.linbo.demo.springcloud.config.UserFeignClientConfig;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author LinBo
 * @date 2018/12/4 11:43
 */
@FeignClient(name = "producer", configuration = UserFeignClientConfig.class, fallbackFactory = UserFallbackFactory.class)
public interface IUserService extends IBasicUserserService {


}

//@Configuration
//class UserFeignClientConfig {
//
//    @Bean
//    public BasicAuthRequestInterceptor userAuthRequestInterceptor() {
//        return new BasicAuthRequestInterceptor("user", "123456");
//    }
//        @Autowired
//        private ObjectFactory<HttpMessageConverters> messageConverters;
//
//        @Bean
//        public Encoder feignFormEncoder() {
//            System.out.println("sdfsdfsdfsdf------------------------------------");
//            Encoder myEncoder = new Encoder() {
//                @Override
//                public void encode(Object o, Type type, RequestTemplate requestTemplate) throws EncodeException {
//                    throw new RuntimeException("sssssssssssssssssssssssss");
//                }
//            };
////            return myEncoder;
//            return new SpringFormEncoder(myEncoder);
////            return new SpringFormEncoder(new SpringEncoder(messageConverters));
//        }

//        @Bean
//        public Encoder getEncoder() {
//            return new Encoder() {
//                @Override
//                public void encode(Object o, Type type, RequestTemplate requestTemplate) throws EncodeException {
//                    throw new RuntimeException("sssssssssssssssssssssssss");
//                }
//            };
//        }

//        @Bean
//        public Feign getEncoder(Decoder decoder, Encoder encoder, Client client, Contract contract) {
//            BasicAuthRequestInterceptor basicAuthRequestInterceptor = new BasicAuthRequestInterceptor("user", "123456");
//            Encoder myEncoder = new Encoder() {
//                @Override
//                public void encode(Object o, Type type, RequestTemplate requestTemplate) throws EncodeException {
//                    throw new RuntimeException("sssssssssssssssssssssssss");
//                }
//            };
//            Feign feign = Feign.builder().encoder(myEncoder).decoder(decoder).client(client).contract(contract)
//                    .requestInterceptor(basicAuthRequestInterceptor).build();
//            return feign;
//        }

//        @Bean
//        public Contract feignContract() {
//            return new feign.Contract.Default();
//        }
//}